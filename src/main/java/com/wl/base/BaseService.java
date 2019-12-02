package com.wl.base;

import java.io.Serializable;

import org.springframework.stereotype.Service;

@Service
public class BaseService<T, ID extends Serializable> extends BaseDao<T, ID>{

}
