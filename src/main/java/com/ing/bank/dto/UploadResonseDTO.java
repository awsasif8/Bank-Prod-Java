package com.ing.bank.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UploadResonseDTO {
	private int statusCode;
	private String status;
	private String message;
}
