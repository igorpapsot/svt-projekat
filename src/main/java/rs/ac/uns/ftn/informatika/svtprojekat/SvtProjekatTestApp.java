package rs.ac.uns.ftn.informatika.svtprojekat;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import rs.ac.uns.ftn.informatika.svtprojekat.entity.Admin;


@SpringBootApplication
public class SvtProjekatTestApp {

    public static void main(String[] args) {
        SpringApplication.run(SvtProjekatTestApp.class, args);

        Admin a = new Admin();
        a.setId(1);
        System.out.println(a.getId());
        System.out.println(a.toString());
        System.out.println(a.hashCode());
    }

}
