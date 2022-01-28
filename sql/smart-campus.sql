create table smart_campus.T_APPLY_INFO
(
    ID           varchar(40)  not null comment '主键ID'
        primary key,
    USER_ID      varchar(40)  null comment '用户ID',
    APPLY_NO     varchar(40)  null comment '申请编号',
    LEAVE_TIME   date         null comment '离校时间',
    RETURN_TIME  date         null comment '返校时间',
    DAYS         varchar(10)  null comment '离校具体天数',
    HOME_ADDRESS varchar(50)  null comment '家庭住址',
    GUARDIAN_TEL varchar(20)  null comment '监护人联系方式',
    TRAFFIC_TYPE varchar(20)  null comment '交通工具',
    TRAFFIC_NUM  varchar(20)  null comment '交通工具班次',
    MANAGER_ID   varchar(50)  null comment '管理员ID',
    APPLY_STATE  varchar(2)   null comment '申请状态 1:待审批 0:已审批',
    APPLY_REASON varchar(256) null comment '申请原因',
    NAME         varchar(50)  null comment '姓名',
    APPLY_TIME   date         null comment '申请时间',
    CREATE_TIME  date         null comment '创建时间',
    UPDATE_TIME  date         null comment '更新时间'
)
    comment '用户申请信息表';

create index T_APPLY_INFO_APPLY_NO_index
    on smart_campus.T_APPLY_INFO (APPLY_NO);

create index T_APPLY_INFO_MANAGER_ID_index
    on smart_campus.T_APPLY_INFO (MANAGER_ID);

create index T_APPLY_INFO_USER_ID_index
    on smart_campus.T_APPLY_INFO (USER_ID);

create table smart_campus.T_APPROVAL_RECORD
(
    ID              varchar(40)  not null comment '主键ID'
        primary key,
    USER_ID         varchar(40)  null comment '用户ID',
    APPLY_NO        varchar(40)  null comment '申请编号',
    NAME            varchar(40)  null comment '姓名',
    APPROVAL_RESULT varchar(40)  null comment '审批结果 1:批准 0: 驳回',
    APPROVAL_TIME   date         null comment '审批时间',
    APPROVAL_PERSON varchar(10)  null comment '审批人',
    UPDATE_TIME     date         null comment '更新时间',
    CREATE_TIME     date         null comment '创建时间',
    APPROVAL_REASON varchar(256) null comment '批准或驳回原因'
)
    comment '审批记录表';

create index T_APPROVAL_RECORD_APPLY_NO_index
    on smart_campus.T_APPROVAL_RECORD (APPLY_NO);

create index T_APPROVAL_RECORD_USER_ID_index
    on smart_campus.T_APPROVAL_RECORD (USER_ID);

create table smart_campus.T_DICTIONARY
(
    ID          varchar(40) not null comment '主键ID'
        primary key,
    DIC_TYPE    varchar(40) null comment '字典项类型',
    DIC_VALUE   varchar(40) null comment '字典项值',
    DIC_CODE    varchar(50) null comment '字典项编码',
    ENABLE      varchar(1)  null comment '是否启用',
    CREATE_TIME date        null comment '创建时间',
    UPDATE_TIME date        null comment '更新时间'
)
    comment '字典表';

create table smart_campus.T_MENU
(
    ID        varchar(50) not null comment '菜单表'
        primary key,
    MENU_ID   int         null comment '菜单ID',
    URL       varchar(50) null comment 'url',
    PATH      varchar(50) null comment '路由路径',
    COMPONENT varchar(50) null comment '路由组件名',
    NAME      varchar(50) null comment '名称',
    ICON      varchar(50) null comment '菜单图标',
    PARENT_ID int         null comment '上级ID',
    ENABLE    varchar(10) null comment '是否启用'
)
    comment '菜单表';

create table smart_campus.T_MENU_ROLE
(
    ID      varchar(50) not null comment '主键ID'
        primary key,
    USER_ID varchar(40) null comment '用户ID',
    ROLE_ID int         null comment '角色ID',
    MENU_ID int         null comment '菜单ID'
)
    comment '菜单角色关系表';

create table smart_campus.T_ROLE
(
    ID        varchar(50) not null comment '主键ID'
        primary key,
    ROLE_ID   int         null comment '角色ID',
    ROLE_CODE varchar(50) null comment '角色code',
    ROLE_NAME varchar(50) null comment '角色名称'
)
    comment '角色表';

create table smart_campus.T_USER
(
    ID       varchar(50)  not null comment '主键ID'
        primary key,
    USER_ID  varchar(40)  null comment '用户ID',
    USERNAME varchar(256) null comment '用户名',
    PASSWORD varchar(100) null comment '密码',
    ENABLED  tinyint(1)   null,
    constraint T_USER_USERNAME_uindex
        unique (USERNAME)
)
    comment '用户表';

create index T_USER_USER_ID_index
    on smart_campus.T_USER (USER_ID);

create table smart_campus.T_USER_INFO
(
    ID               varchar(50)  not null comment '主键ID'
        primary key,
    USER_ID          varchar(50)  null comment '用户ID',
    STUDENT_ID       varchar(40)  null comment '学号',
    NAME             varchar(40)  null comment '姓名',
    SEX              varchar(10)  null comment '性别',
    ID_CARD_NUM      varchar(20)  null comment '身份证号',
    CLASS_NAME       varchar(50)  null comment '班级',
    DOMICILE         varchar(50)  null comment '户籍地',
    BIRTH_TIME       date         null comment '出生日期',
    FATHER_TEL       varchar(20)  null comment '父亲联系方式',
    MOTHER_TEL       varchar(20)  null comment '母亲联系方式',
    POLITICAL_STATUS varchar(10)  null comment '政治面貌',
    AGE              varchar(10)  null comment '年龄',
    ROLE_ID          varchar(10)  null comment '角色编码',
    MANAGER_ID       varchar(40)  null comment '上级管理员ID',
    COGNITION        varchar(20)  null comment '任职情况',
    TELEPHONE        varchar(20)  null comment '个人联系方式',
    COLLEGE          varchar(50)  null comment '学院',
    UPDATE_TIME      date         null comment '更新时间',
    CREATE_TIME      date         null comment '创建时间',
    CLAN             varchar(10)  null comment '名族',
    ENTER_TIME       date         null comment '入学时间',
    PROFESSIONAL     varchar(40)  null comment '专业',
    REMARK           varchar(256) null comment '备注',
    CURRENT_ADDRESS  varchar(50)  null comment '现居住地',
    constraint T_USER_INFO_USER_ID_uindex
        unique (USER_ID)
)
    comment '用户信息表';

create index T_USER_INFO_MANAGER_ID_index
    on smart_campus.T_USER_INFO (MANAGER_ID);

create index T_USER_INFO_USER_ID_index
    on smart_campus.T_USER_INFO (USER_ID);

create table smart_campus.T_USER_ROLE
(
    ID      varchar(50) null comment '主键ID',
    USER_ID varchar(40) null comment '用户ID',
    ROLE_ID int         null comment '角色ID'
)
    comment '用户角色关系表';

create index T_USER_ROLE_USER_ID_index
    on smart_campus.T_USER_ROLE (USER_ID);


