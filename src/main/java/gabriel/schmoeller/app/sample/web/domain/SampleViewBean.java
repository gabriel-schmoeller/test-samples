package gabriel.schmoeller.app.sample.web.domain;

import java.time.LocalDateTime;
import java.util.Objects;

public class SampleViewBean {

    private Long id;
    private String name;
    private LocalDateTime date;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleViewBean viewBean = (SampleViewBean) o;
        return Objects.equals(id, viewBean.id)
                && Objects.equals(name, viewBean.name)
                && Objects.equals(date, viewBean.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, date);
    }

    @Override
    public String toString() {
        return "SampleViewBean{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", date=" + date
                + '}';
    }
}
