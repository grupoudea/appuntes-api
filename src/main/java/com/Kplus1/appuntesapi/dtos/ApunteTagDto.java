package com.Kplus1.appuntesapi.dtos;

import lombok.Data;

@Data
public class ApunteTagDto {
    private Integer id;
    private Integer idApunte;
    private ApunteDto apunte;
    private Integer idTagFk;
    private TagDto tag;
}
