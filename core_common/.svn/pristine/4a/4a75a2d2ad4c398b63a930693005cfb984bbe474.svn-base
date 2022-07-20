package com.util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class FileUtil {

	public static final String FILE_SEPARATOR = System.getProperty("file.separator");
	public static final int BUFFER_SIZE = 4096;

	public static byte[] zipFile2Byte(String directory, String[] files) throws IOException {
		ByteArrayOutputStream baos = null;
		ZipOutputStream zos = null;
		try {
			baos = new ByteArrayOutputStream();
			zos = new ZipOutputStream(baos);

			byte bytes[] = new byte[BUFFER_SIZE];

			for (String fileName : files) {
				FileInputStream fis = new FileInputStream(directory + FILE_SEPARATOR + fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);

				zos.putNextEntry(new ZipEntry(fileName));

				int bytesRead;
				while ((bytesRead = bis.read(bytes)) != -1) {
					zos.write(bytes, 0, bytesRead);
				}

				zos.closeEntry();
				bis.close();
				fis.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (zos != null) {
				zos.flush();
				zos.close();
			}

			if (baos != null) {
				baos.flush();
				baos.close();
			}
		}

		return baos.toByteArray();
	}

	public static void unZipFiles(ZipInputStream zipIn, String filePath) throws IOException {
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
		byte[] bytesIn = new byte[BUFFER_SIZE];
		int read = 0;
		while ((read = zipIn.read(bytesIn)) != -1) {
			bos.write(bytesIn, 0, read);
		}
		bos.close();
	}

	public static boolean delFile(String path, String fileDel) {
		try {
			boolean result = (new File(path + fileDel)).delete();
			return result;
		} catch (Exception e) {
			return false;
		}

	}

	public static int getLineNumber(File file) throws IOException {
		int totalLine = 0;
		LineNumberReader lnr = null;
		try {
			lnr = new LineNumberReader(new FileReader(file));
			lnr.skip(Long.MAX_VALUE);
			totalLine = lnr.getLineNumber();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (lnr != null) {
				lnr.close();
			}
		}

		return totalLine;
	}

	public static ByteArrayOutputStream zipFile2Stream(String directory, String[] files) throws IOException {
		ByteArrayOutputStream baos = null;
		ZipOutputStream zos = null;
		try {
			baos = new ByteArrayOutputStream();
			zos = new ZipOutputStream(baos);

			byte bytes[] = new byte[BUFFER_SIZE];

			for (String fileName : files) {
				FileInputStream fis = new FileInputStream(directory + FILE_SEPARATOR + fileName);
				BufferedInputStream bis = new BufferedInputStream(fis);

				zos.putNextEntry(new ZipEntry(fileName));

				int bytesRead;
				while ((bytesRead = bis.read(bytes)) != -1) {
					zos.write(bytes, 0, bytesRead);
				}

				zos.closeEntry();
				bis.close();
				fis.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (zos != null) {
				zos.flush();
				zos.close();
			}

			if (baos != null) {
				baos.flush();
				baos.close();
			}
		}

		return baos;
	}
	
	public static void close(AutoCloseable... array) {
		for (AutoCloseable c : array) {
			try {
				c.close();
			} catch (IOException e) {
			} catch (Exception e) {
			}
		}
	}
}
