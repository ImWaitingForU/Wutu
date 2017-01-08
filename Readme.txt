伍途APP:

版本号:1.0.0.0(版本号暂时不用管，应用发布后再进行版本升级)

新包名说明:

    login : 登录
    register:注册
    home  : 主页 //修改成用四个Fragment组成首页，不使用滑动

    military : 军事天地 -- Jun
    society : 社团
    manage : 时间/目标管理
    me:我的界面

    utils  : 工具类
    views :自定义控件

    propaganda : 征兵宣传 --删除
    enroll : 征兵报名 -- 删除
    policy : 征兵政策 -- 删除

    ...


已确定要用到的依赖：(版本可变)

图片加载：picasso   compile 'com.squareup.picasso:picasso:2.5.2'
网络请求：volley     compile 'com.android.volley:volley:1.0.0'
引导页/广告轮播:   compile 'com.android.support:support-v4:2.1.6'
                  compile 'cn.bingoogolapple:bga-banner:2.1.6@aar'

显示密码的Edittext: compile 'com.maksim88:PasswordEditText:v0.9'
依赖注入ButterKnife： compile 'com.jakewharton:butterknife:8.4.0'
                   annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'

BaseRecylerViewAdapterHelper:    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:v2.0.0'

其他:
下拉刷新使用SwipeRefreshLayout;


关于代码规范：

    1见名知意
    2方法使用文档注释(/** xxx **/),必要时标明参数返回值等
    3全局变量使用mXXX,静态使用sXXX,常量大写，单词之间用下划线分割_
    4String/Color/Style等能复用的尽量卸载xml文件里
    5其他遵循基本注释原则

关于版本控制:

    使用git 远程仓库使用github.

    分支:
    master分支操作， 如果怕代码混乱自行branch

    如果使用同一个分支请务必
    每次修改完及时提交到github,每次开始编辑从github更新
    随时备份代码

关于签名和混淆：

    应用完成再考虑。。

随时更新
