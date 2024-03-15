package JavaTester.OOP;

public  class Topic_04_Non_Access_Modifier {
    // static Variable/Method của class
    // dùng cho tất cả instance
    // sử dụng cho toàn bộ system sử dụng nó, các class khác có thể dùng được
    // có thể override được / gán giá trị mới được
    static String browserName = "Chrome";
    // Non static - instance
    String versionName = " Testing";
    // hằng số
    final String colorCar = "Red";
    final static String REGISTER_BUTTON = "";
    public static void main(String[] args){
        System.out.println(browserName);
        browserName = "FireFox";
        System.out.println(browserName);
    // truy cập thông qua ọbject
//        Topic_04_Non_Access_Modifier obj = new Topic_04_Non_Access_Modifier();
//        System.out.println(obj.versionName);
//        System.out.println(obj.colorCar);
    }

    // Method
    // Static
    // Final
    // Abstract class chỉ được dùng thông qua kế thừa, không được phép dùng thông qua khởi tạo đối tương
    public final void setCarName (){

    }


}
