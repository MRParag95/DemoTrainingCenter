package com.mendax47.springboot.projects.trainingcenter.services;

import com.mendax47.springboot.projects.trainingcenter.repository.AbstractRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;

@Service
@AllArgsConstructor
public class AbstractService<T, V> {
    private AbstractRepository<T, V> abstractRepository;

    public T create(T model) {
        return this.abstractRepository.save(model);
    }

    public List<T> findAll() {
        return this.abstractRepository.findAll();
    }

    public T findOne(V id) {
        return this.abstractRepository.findById(id).orElseThrow();
    }

    public T updateOne(V id, T model) {
        T foundModel = this.findOne(id);

        if (foundModel == null) {
//            throw new RuntimeException(model.getClass().getSimpleName() + " not found.");
            throw new RuntimeException("Item not found.");
        }

        Class<?> targetModel = foundModel.getClass();
        Class<?> sourceModel = model.getClass();

        Field[] allSourceModelFields = sourceModel.getDeclaredFields();
        Field[] allTargetModelFields = targetModel.getDeclaredFields();

        if (allTargetModelFields.length != allSourceModelFields.length) {
            throw new RuntimeException("Invalid Model.");
        }

        for (Field targetField: allTargetModelFields) {
            targetField.setAccessible(true);

            try {
                Field sourceField = sourceModel.getDeclaredField(targetField.getName());
                sourceField.setAccessible(true);

                targetField.set(foundModel, sourceField.get(model));
            }
            catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }

        return this.abstractRepository.save(foundModel);
    }

    public String deleteOne(V id) {
        T foundModel = this.findOne(id);

        if (foundModel == null) {
            throw new RuntimeException("Item not found.");
        }

        this.abstractRepository.delete(foundModel);

        return "Item Deleted Successfully";
    }
}