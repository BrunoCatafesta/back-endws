package com.testbackend.business.ordered;

import com.testbackend.architecture.exception.EnumException;
import com.testbackend.architecture.exception.TestBackEndRuntime;
import com.testbackend.entity.Ordered;
import com.testbackend.entity.StatusOrdered;
import com.testbackend.enun.EnumStatusOrdered;
import com.testbackend.persistence.OrderedRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManipulatorStatusOrdered {

	@Autowired
	private OrderedRepository orderedRepository;

	public void applyStatus(Long id, EnumStatusOrdered enumStatusOrdered) {
		orderedRepository.find(id)
			.ifPresent(order -> changeStatus(order, enumStatusOrdered));	
	}
	
	private void changeStatus(Ordered order, EnumStatusOrdered enumStatus) {
		if (!order.isPending()) {
            StatusOrdered status = order.getStatus();
            throw new TestBackEndRuntime(EnumException.CANNOT_CHANGED_STATUS_ORDERED, status.getStatus());
		}
		order.setStatus(enumStatus.getStatusOrdered());
		orderedRepository.merge(order);
	}

}