package com.opcbiz.fxprimus.utils;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import com.opcbiz.fxprimus.dto.qa19.AccountDto;

public class TextUtils {

	public static void writeFileWithListAccounts(List<AccountDto> listAccountDto, String filePath) {
		try {
			FileOutputStream fos = new FileOutputStream(filePath);
			DataOutputStream dos = new DataOutputStream(fos);
			for (AccountDto accountDto : listAccountDto) {
				String str = accountDto.toString() +"\n";
				dos.writeBytes(str);
				
			}
			fos.close();
			dos.close();
			System.out.println("Done!");
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
