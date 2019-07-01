package cn.itsource.common.base;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * 代号: 隐无为
 * 用途：基类接口
 */
public interface BaseService<T> {

    /**
     * @功能: 分页查询
     * @代号: 隐无为
     */
    public PageInfo<T> queryPageList(Integer pageNum, Integer pageSize);

    /**
     * @功能:分页查询（默认pageSize）
     * @代号:隐无为
     */
    public PageInfo<T> queryPageList(Integer pageNum);

    /**
     * @功能:条件参数分页查询
     * @代号:隐无为
     */
    public PageInfo<T> queryPageListByParam(Integer pageNum, Integer pageSize, T model);

    /**
     * @return
     * @功能:条件参数分页查询（默认pageSize）
     * @代号:隐无为
     */
    public PageInfo<T> queryPageListByParam(Integer pageNum, T model);

    /**
     * @功能:查询所有
     * @代号:隐无为
     */
    public List<T> queryAllList();

    /**
     * @param model
     * @功能:带有条件参数的查询
     * @代号:隐无为
     */
    public List<T> queryParamList(T model);

    /**
     * @功能:查询单个实体类
     * @代号:隐无为
     */
    public T queryById(Object id);

    /**
     * @return
     * @功能:带有条件参数单个实体类的查询
     * @代号:隐无为
     */
    public T queryByParam(T model);

    /**
     * @param model
     * @功能:根据实体中的属性查询总数
     * @代号:隐无为
     */
    public Integer queryCount(T model);

    /**
     * @param model
     * @功能:保存一个实体 null值的属性也会保存，不会使用数据库默认值
     * @代号:隐无为
     */
    public Integer insert(T model);

    /**
     * @param model
     * @功能:保存一个实体，null值的属性不会保存，会使用数据库默认值
     * @代号:隐无为
     */
    public Integer insertNoNull(T model);

    /**
     * @param model
     * @return
     * @功能:根据实体属性作为条件进行删除
     * @代号:隐无为
     */
    public Integer deleteByParam(T model);

    /**
     * @param
     * @功能:根据主键字段进行删除
     * @代号:隐无为
     */
    public Integer delete(Object id);

    /**
     * @param model
     * @return
     * @功能:根据主键更新实体全部字段，null值会被更新
     * @代号:隐无为
     */
    public Integer update(T model);

    /**
     * @param model
     * @功能:根据主键更新属性不为null的值
     * @代号:隐无为
     */
    public Integer updateNoNull(T model);

    ///////////////////////////////////////////////////////
    //
    // 批量
    //
    ///////////////////////////////////////////////////////

    /**
     * @param list
     * @功能:批量添加
     * @代号:隐无为
     */
    public Integer insertList(List<T> list);

    /**
     * @param ids
     * @功能:根据主键字符串进行批量删除，类中要有一个带有@Id注解的字段
     * @代号:隐无为
     */
    public Integer deleteByIds(String ids);

    /**
     * @param ids
     * @功能:ids批量查询，类中要有一个带有@Id注解的字段
     * @代号:隐无为
     */
    public List<T> queryByIds(String ids);

    /**
     * @param list
     * @功能:批量更新
     * @代号:隐无为
     */
    public Integer updateList(List<T> list);

    ///////////////////////////////////////////////////////
    //
    // 扩展
    //
    ///////////////////////////////////////////////////////

    /**
     * @param model
     * @功能:逻辑删除
     * @代号:隐无为
     */
    public Integer updateDelete(T model);


}
