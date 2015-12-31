package molemo.quotejob.repositories;

import java.util.List;

import molemo.quotejob.domain.AddJob;

/**
 * Created by tsemol01 on 2015/12/03.
 */
public interface RestAPI <S, ID>{

    S get(ID id);

    String post(S entity);

    String put(AddJob entity);

    String delete(AddJob entity);

    List<S> getAll();

}
