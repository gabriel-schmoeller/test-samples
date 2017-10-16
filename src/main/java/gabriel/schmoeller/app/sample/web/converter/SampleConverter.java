package gabriel.schmoeller.app.sample.web.converter;

import gabriel.schmoeller.app.sample.persistence.SampleEntity;
import gabriel.schmoeller.app.sample.web.domain.SampleViewBean;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class SampleConverter {

    public SampleViewBean encode(SampleEntity entity) {
        SampleViewBean viewBean = new SampleViewBean();
        viewBean.setId(entity.getId());
        viewBean.setName(entity.getName());
        viewBean.setDate(entity.getDate());

        return viewBean;
    }

    public SampleEntity dencode(SampleViewBean viewBean) {
        SampleEntity entity = new SampleEntity();
        entity.setId(viewBean.getId());
        entity.setName(viewBean.getName());
        entity.setDate(viewBean.getDate());

        return entity;
    }

    public List<SampleViewBean> encodeAll(Collection<SampleEntity> entities) {
        return entities.stream()
                .map(this::encode)
                .collect(Collectors.toList());
    }

    public List<SampleEntity> dencodeAll(Collection<SampleViewBean> viewBeans) {
        return viewBeans.stream()
                .map(this::dencode)
                .collect(Collectors.toList());
    }
}
