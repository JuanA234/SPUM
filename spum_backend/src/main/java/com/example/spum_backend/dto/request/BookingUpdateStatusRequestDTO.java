package com.example.spum_backend.dto.request;

import com.example.spum_backend.enumeration.BookingStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookingUpdateStatusRequestDTO {

    BookingStatusEnum status;
    Long bookingId;

}
