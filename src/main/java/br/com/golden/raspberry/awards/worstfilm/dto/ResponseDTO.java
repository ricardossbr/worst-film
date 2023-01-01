package br.com.golden.raspberry.awards.worstfilm.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ResponseDTO {
    private String producer;
    private int interval;
    private String previousWin;
    private String followingWin;
}
