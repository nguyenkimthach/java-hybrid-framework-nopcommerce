package utilities;

import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;

import com.github.javafaker.Faker;

public class DataHelper {
	private Locale local = new Locale("en");
	private Faker faker = new Faker(local);

	public static DataHelper getDataHelper() {
		return new DataHelper();
	}

	public String getFirstname() {
		return faker.name().firstName();
	}

	public String getLastname() {
		return faker.name().lastName();
	}

	public String getFullname() {
		return faker.name().fullName();
	}

	public String getGenderMaleAndFemale() {
		if (new Random().nextInt(2) == 0)
			return "Female";
		else
			return "Male";
	}

	public String getEmailAddress() {
		return faker.internet().emailAddress();
	}

	public String getPassword() {
		return faker.internet().password(8, 12, true, true);
	}

	public String getCityName() {
		return faker.address().cityName();
	}

	public String getPhone() {
		return faker.phoneNumber().phoneNumber();
	}

	public String getAddress() {
		return faker.address().streetAddress();
	}

	public String getState() {
		return faker.address().state();
	}

	public String getZipCode() {
		return faker.address().zipCodeByState(faker.address().state());
	}

	public String getZipCodeByState() {
		return faker.address().zipCode();
	}

	public String getCapital() {
		return faker.country().capital();
	}

	public String getCompanyName() {
		return faker.company().name();
	}

	public String getCreditCardNumber() {
		return faker.business().creditCardNumber();
	}

	public String getBirthDay() {
		return new SimpleDateFormat("MM/dd/yyyy").format(faker.date().birthday());
	}

	private String transferMonthNumberToChacraceter(String monthNumberString) {
		switch (monthNumberString) {
		case "01":
			return "January";
		case "02":
			return "February";
		case "03":
			return "March";
		case "04":
			return "April";
		case "05":
			return "May";
		case "06":
			return "June";
		case "07":
			return "July";
		case "08":
			return "August";
		case "09":
			return "September";
		case "10":
			return "October";
		case "11":
			return "November";
		case "12":
			return "December";

		default:
			throw new IllegalArgumentException("NumberString of month is not supported");
		}
	}

	public String getTimeDay() {
		String day = getBirthDay().split("/", 3)[1];
		return day.startsWith("0") ? day.substring(1) : day;
	}

	public String getTimeMonthChacrater() {
		return transferMonthNumberToChacraceter(getBirthDay().split("/", 3)[0]);
	}

	public String getTimeYear() {
		return getBirthDay().split("/", 3)[2];
	}

}
