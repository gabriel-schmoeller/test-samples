package gabriel.schmoeller.app.sample.web;

import gabriel.schmoeller.app.sample.persistence.ThingEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/thing")
public class ThingController {

    @GetMapping
    public List<ThingEntity> listThings() {
        return new ArrayList<ThingEntity>();
    }

    @PostMapping
    public List<ThingEntity> createThings() {
        return new ArrayList<ThingEntity>();
    }
}
