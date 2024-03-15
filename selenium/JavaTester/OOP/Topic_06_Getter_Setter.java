package JavaTester.OOP;

public class Topic_06_Getter_Setter {

    // kiểm tra/ validate dữ liệu
    public String personName;
    public int personAge ;
    public int personPhone;

    // setter
    public void setPersonName(String personName){
        if (personName == null || personName.isEmpty()) {
            throw new IllegalArgumentException("Tên bạn nhập vào không hợp lệ");
        }
        else {
            // cùng tên với local dùng this để lấy value
            this.personName = personName;
        }
    }

    // getter
    public String getPersonName(){
        return this.personName;
    }
    public void setPersonAge(int personAge) {
        if (personAge <15 && personAge >60) {
            throw new IllegalArgumentException(" tuổi nhập vào không hợp lệ");
        } else {
            this.personAge = personAge;
        }
    }
    public int getPersonAge(){
        return this.personAge;
    }
    public void setPersonPhone(int personPhone){
        if (!String.valueOf(personPhone).startsWith("0")){
            throw new IllegalArgumentException("vui lòng nhập số điện thoại hợp lệ");
        }
        else if (personPhone<10 || personPhone>11){
            throw new IllegalArgumentException(" vui lòng nhập số điện thoại hợp lệ");
        }
        else{
            this.personPhone = personPhone;
        }
    }
    public int getPersonPhone(){
        return this.personPhone;
    }

}
