package com.example.spum_backend.service.impl;

import com.example.spum_backend.dto.request.BookingRequestDTO;
import com.example.spum_backend.dto.response.BookingResponseDTO;
import com.example.spum_backend.entity.Booking;
import com.example.spum_backend.entity.Item;
import com.example.spum_backend.entity.Penalty;
import com.example.spum_backend.entity.Student;
import com.example.spum_backend.enumeration.BookingStatusEnum;
import com.example.spum_backend.exception.UserHasInProcessPenalty;
import com.example.spum_backend.repository.BookingRepository;
import com.example.spum_backend.service.interfaces.BookingService;
import com.example.spum_backend.service.interfaces.internal.ItemServiceEntity;
import com.example.spum_backend.service.interfaces.internal.PenaltyServiceEntity;
import com.example.spum_backend.service.interfaces.internal.StudentServiceEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final ItemServiceEntity itemServiceEntity;
    private final PenaltyServiceEntity penaltyServiceEntity;
    private final StudentServiceEntity studentServiceEntity;
    private final ModelMapper modelMapper;

    public BookingServiceImpl(BookingRepository bookingRepository, ItemServiceEntity itemServiceEntity, PenaltyServiceEntity penaltyServiceEntity, StudentServiceEntity studentServiceEntity, ModelMapper modelMapper) {
        this.bookingRepository = bookingRepository;
        this.itemServiceEntity = itemServiceEntity;
        this.penaltyServiceEntity = penaltyServiceEntity;
        this.studentServiceEntity = studentServiceEntity;
        this.modelMapper = modelMapper;
    }

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO booking) {

        Item itemToBook = itemServiceEntity.getItemById(booking.getItemId());

        // Look for active penalties

        Optional<Penalty> penalty = penaltyServiceEntity.findActivePenalty(booking.getUserId(), booking.getStartTime());

        if(penalty.isEmpty()) {
            throw new UserHasInProcessPenalty("User can not book an item because there are active penalties");
        }

        // Look if user exists

        Student student = studentServiceEntity.getStudentById(booking.getUserId());

        // Creating booking

        Booking booking1 = Booking
                .builder()
                .startTime(booking.getStartTime())
                .endTime(booking.getStartTime().plusHours(2L))
                .bookingStatus(BookingStatusEnum.IN_PROCESS)
                .student(student)
                .item(itemToBook)
                .build();

        bookingRepository.save(booking1);

        // Update item quantity
        itemToBook.setItemQuantity(itemToBook.getItemQuantity() - 1);
        itemServiceEntity.saveItem(itemToBook);

        return modelMapper.map(booking1, BookingResponseDTO.class);
    }
}
