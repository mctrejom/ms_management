package co.com.books.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private Long userId;
    private Long bookId;
    private Long quantityDays;
}
