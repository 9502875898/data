package com.pageNation.pagenationdata.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PagenationDto {
    private  int pageNumber;
    private  int pageSize;
    private  String sortOrder;
}
