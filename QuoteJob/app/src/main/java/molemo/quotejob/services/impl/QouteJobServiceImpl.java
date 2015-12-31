package molemo.quotejob.services.impl;

import java.util.List;

import molemo.quotejob.domain.AddJob;
import molemo.quotejob.model.AddJobResource;
import molemo.quotejob.repositories.RestAPI;
import molemo.quotejob.repositories.rest.RestQuote;
import molemo.quotejob.services.QouteJobServices;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public class QouteJobServiceImpl implements QouteJobServices{

    final RestAPI<AddJobResource, Long> rest = new RestQuote();

    @Override
    public AddJobResource findById(Long id)
    {
        return rest.get(id);
    }

    @Override
    public String save(AddJobResource entity)
    {
     return rest.post(entity);
    }

    @Override
    public String update(AddJob entity)
    {
     return rest.put(entity);
    }

    @Override
    public String delete(AddJob entity)
    {
        return rest.delete(entity);
    }

    @Override
    public List<AddJobResource> findAll()
    {
     return rest.getAll();
    }

}
