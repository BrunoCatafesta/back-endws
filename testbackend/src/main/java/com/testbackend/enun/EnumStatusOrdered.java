package com.testbackend.enun;

import com.testbackend.architecture.exception.EnumException;
import com.testbackend.architecture.exception.TestBackEndRuntime;
import com.testbackend.entity.StatusOrdered;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public enum EnumStatusOrdered {

    PENDING(new StatusOrdered(1L, "Pending", "pending confirmation")),
    CONFIRMED(new StatusOrdered(2L, "Confirmed", "Confirmed")),
    CANCELED(new StatusOrdered(3L, "Canceled", "Canceled"));

    private StatusOrdered statusOrdered;

    EnumStatusOrdered(StatusOrdered statusOrdered){
        this.statusOrdered = statusOrdered;
    }

    public static List<StatusOrdered> getAllStatus(){
        return Arrays.asList(values()).stream().map(e -> e.getStatusOrdered()).collect(Collectors.toList());
    }
    
    public static EnumStatusOrdered of(StatusOrdered statusOrdered){
        Optional<EnumStatusOrdered> statusLoccated = Arrays.asList(values())
                .stream().filter(e -> e.getStatusOrdered().getId().equals(statusOrdered.getId()))
                .findFirst();

        statusLoccated.orElseThrow(() -> new TestBackEndRuntime(EnumException.STATUS_ORDERED_NOT_FOUND));
        return statusLoccated.get();
    }

    public StatusOrdered getStatusOrdered() {
        return statusOrdered;
    }
}