package lwh.java.serial;

/** 枚举类型默认继承了java.lang.Enum,而Enum实现了Serializable接口
    所以枚举类型对象默认是可以被序列化的
 **/
public enum Gender {
    MALE, FEMALE
}
