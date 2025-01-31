package testing;

public class verifylogin extends testdata {

	public static void main(String[] args) throws Exception {
		testdata validate = new testdata();

		validate.URL("fansadmin@yopmail.com", "123456");

		validate.cookieslection();

		validate.submit();

		validate.checklogin();

		validate.Authorization();

		validate.Manage();

	}

}
