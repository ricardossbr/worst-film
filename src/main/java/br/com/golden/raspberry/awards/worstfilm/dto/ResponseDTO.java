package br.com.golden.raspberry.awards.worstfilm.dto;


import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class ResponseDTO {
    private String producer;
    private int interval;
    private int previousWin;
    private int followingWin;
}
