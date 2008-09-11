/*
 * Copyright 2008 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package samples.expectnew;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.zip.ZipInputStream;

import javax.sound.sampled.AudioInputStream;

import samples.newmocking.MyClass;

public class ExpectNewDemo {

	private int dummyField;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + dummyField;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final ExpectNewDemo other = (ExpectNewDemo) obj;
		if (dummyField != other.dummyField)
			return false;
		return true;
	}

	public String getMessage() {
		MyClass myClass = new MyClass();
		return myClass.getMessage();
	}

	public String getMessageWithArgument() {
		MyClass myClass = new MyClass();
		return myClass.getMessage("test");
	}

	public void invokeVoidMethod() {
		MyClass myClass = new MyClass();
		myClass.voidMethod();
	}

	/**
	 * The purpose of the method is to demonstrate that a test case can mock the
	 * new instance call and throw an exception upon instantiation.
	 */
	public void throwExceptionWhenInvoction() {
		new MyClass();
	}

	public String multipleNew() {
		MyClass myClass1 = new MyClass();
		MyClass myClass2 = new MyClass();

		final String message1 = myClass1.getMessage();
		final String message2 = myClass2.getMessage();
		return message1 + message2;
	}

	public void simpleMultipleNew() {
		new MyClass();
		new MyClass();
		new MyClass();
	}

	public void simpleSingleNew() {
		new MyClass();
	}

	public Date makeDate() {
		return new Date();
	}

	public InputStream alternativePath() {
		try {
			return new DataInputStream(null);
		} catch (RuntimeException e) {
			return new ByteArrayInputStream(new byte[0]);
		}
	}
}
