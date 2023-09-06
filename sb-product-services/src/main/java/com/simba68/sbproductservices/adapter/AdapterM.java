package com.simba68.sbproductservices.adapter;

import com.simba68.sbproductservices.constant.OptionRequestCode;
import com.simba68.sbproductservices.dto.OptionGetDataDTO;
import com.simba68.sbproductservices.entity.Food;
import com.simba68.sbproductservices.factory.ResponseFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpMediaTypeException;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class AdapterM<T> {

    public List<?> adapter(JpaRepository<T, Long> jpa, OptionGetDataDTO option){
        Map<String, OptionRequestCode> mapOption = OptionAdapter.convertEnumToMap();
        String op = option.getOption();
        if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_BY_ID.getValue())){
            return jpa.findById(Long.parseLong(option.getData())).stream().collect(Collectors.toList());
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_NAME_ASC.getValue())){
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).ascending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_NAME_DESC.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).descending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_PRICE_IN_ASCENDING.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).ascending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_PRICE_IN_DESCENDING.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).descending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_QUANTITY_IN_ASCENDING.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).ascending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_QUANTITY_IN_DESCENDING.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).descending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_QUANTITY_AND_PRICE_IN_ASCENDING.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).and(Sort.by(option.getProperties().get(1))).ascending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_QUANTITY_AND_PRICE_IN_DESCENDING.getValue())) {
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).and(Sort.by(option.getProperties().get(1))).descending())).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_QUANTITY_ASC_AND_PRICE_DESC.getValue())){
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).ascending().and(Sort.by(option.getProperties().get(1)).descending()))).toList();
        } else if (mapOption.containsKey(op) && op.equals(OptionRequestCode.FIND_LIMIT_BY_QUANTITY_DESC_AND_PRICE_ASC.getValue())){
            return jpa.findAll(PageRequest.of(option.getPageNumber(), option.getSize(), Sort.by(option.getProperties().get(0)).descending().and(Sort.by(option.getProperties().get(1))).ascending())).toList();
        }
        return new ArrayList<>();
    }

    public T save(JpaRepository<T, Long> jpa, T entity){
        try {
            return jpa.save(entity);
        }catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("save error!!");
        }
    }

    public void delete(JpaRepository<T, Long> jpa,Long id){
        try{
            jpa.deleteById(id);
        }catch (Exception e){
            e.printStackTrace();
            throw new RuntimeException("Delete error!!!");
        }
    }

}
