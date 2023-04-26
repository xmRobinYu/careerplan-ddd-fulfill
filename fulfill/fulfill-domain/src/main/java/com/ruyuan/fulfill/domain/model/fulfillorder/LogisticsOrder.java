package com.ruyuan.fulfill.domain.model.fulfillorder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LogisticsOrder implements Serializable {

    private static final long serialVersionUID = 700602160396461809L;


    private String logisticsId;
}
