package com.example.management_library_system.dto;

import lombok.Data;
import java.util.List;

@Data
public class LoanRequestDTO {
    private String expectedReturnDate;
    private List<Integer> bookIds;
}