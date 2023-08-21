package com.vm.Vyas_Media.Repository;

import org.springframework.data.repository.CrudRepository;
import com.vm.Vyas_Media.Entity.CMSEmployee;
import com.vm.Vyas_Media.Entity.CMSMain;

public interface CMSEmployeeRepository extends CrudRepository<CMSEmployee, Integer> {

	CMSMain save(CMSMain laptop);

}
