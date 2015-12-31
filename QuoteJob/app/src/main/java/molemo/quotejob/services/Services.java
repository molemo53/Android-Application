package molemo.quotejob.services;

import java.util.List;

import molemo.quotejob.domain.AddJob;
import molemo.quotejob.model.AddJobResource;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public interface Services <H, ID>{

    public H findById(ID id);
    public String save(H entity);

    public String update(AddJob entity);

    public String delete(AddJob entity); // Getter, GET implements Resource Support, Post Supports Entity model

    public List<H> findAll();


}
