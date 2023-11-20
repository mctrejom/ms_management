package co.com.books.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table("loan")
public class Loan {
    @Id
    private Long id;
    private Long userId;
    private Long bookId;
    private LocalDate created_at;
    private LocalDate return_date;
    private Boolean returned;
}
