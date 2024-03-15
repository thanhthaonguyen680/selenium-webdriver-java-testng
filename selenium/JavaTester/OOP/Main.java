package JavaTester.OOP;
interface DongVatCaSi{
 void hat();

}
// interface : tất cả method trong interface đều là abstract method nên ko cần khai báo abstract
abstract class DongVat{
 public abstract void noi ();
 // phương thức nói ko có phần thân vì nó là abstract method
 public void ngu(){
  System.out.println(" Dong vat dang ngu");
 }
}
class HoaMi extends DongVat implements DongVatCaSi{

 @Override
 public void hat() {
  System.out.println("lalala");
 }

 @Override
 public void noi() {
  System.out.println("ABC");
 }
}
class Meo extends DongVat{
 @Override
 // Annotation Override : phương thức nói là PT ghi đè lên PT dc khai báo lớp cha
 public void noi() {
  System.out.println(" meo meo");

 }
}
// Java class nào nới rộng ( extends) từ abstract class phải implement all the method abstract of
// abtract
public class Main {
 public static void main(String[] args) {
  // DongVat dongVat = new DongVat();
  // => DongVat class không thể khởi tạo thông qua đối tượng
DongVat dongVat = new Meo();
dongVat.ngu();
dongVat.noi();
DongVatCaSi dongVatCaSi = new HoaMi();
  dongVatCaSi.hat();
 }
}
