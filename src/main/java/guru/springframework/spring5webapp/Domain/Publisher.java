package guru.springframework.spring5webapp.Domain;


import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Publisher {

    private String name;
    private String zip;
    private String address;
    private String state;
    private String city;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public Publisher() {
    }

    public Set<Book> getBooks() {
        return books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Publisher(String name, String zip, String address, String state, String city) {
        this.zip = zip;
        this.address = address;
        this.state = state;
        this.city = city;
        this.name = name;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publisher publisher = (Publisher) o;
        return Objects.equals(name, publisher.name) && Objects.equals(zip, publisher.zip) && Objects.equals(address, publisher.address) && Objects.equals(state, publisher.state) && Objects.equals(city, publisher.city) && Objects.equals(id, publisher.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, zip, address, state, city, id);
    }

    @Override
    public String toString() {
        return "Publisher{" +
                "name='" + name + '\'' +
                ", zip='" + zip + '\'' +
                ", address='" + address + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", id=" + id +
                '}';
    }
}
