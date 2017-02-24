伍途APP:

版本号:1.0.0.0(版本号暂时不用管，应用发布后再进行版本升级)

新修改主界面布局后(170130):

底部:

    Military:   军事
        包括:军事新闻(征兵宣传嵌入该页),每3条新闻后插入一条视频。

    Society:    社团
        包括:社团基本信息，社团人员，社团活动

    Weapon:     武器
        包括:嵌入3D模型

    More:       更多
        包括:仿知乎更多

新包名说明:

    login : 登录
    register:注册
    home  : 主页 //修改成用四个Fragment组成首页，不使用滑动

    military : 军事天地 -- Jun（合并：征兵宣传、征兵报名、征兵政策）//内部
加入嵌套fragment，由于考虑需要做的新颖别致，界面还待改进

    society : 社团
    manage : 时间/目标管理
    me:我的界面

    utils  : 工具类
    views :自定义控件

    ...


已确定要用到的依赖：(版本可变)

图片加载：picasso   compile 'com.squareup.picasso:picasso:2.5.2'
网络请求：volley     compile 'com.android.volley:volley:1.0.0'
引导页/广告轮播:   compile 'com.android.support:support-v4:2.1.6'
                  compile 'cn.bingoogolapple:bga-banner:2.1.6@aar'
		compile 'com.nineoldandroids:library:2.4.0' 
多布局列表，自带上下拉: //LazyRecyclerView
    compile 'com.github.CarGuo:LazyRecyclerAdapter:v2.0.0'（数据待后台加入，考虑使用视频新闻混合显示）

显示密码的Edittext: compile 'com.maksim88:PasswordEditText:v0.9'
依赖注入ButterKnife： compile 'com.jakewharton:butterknife:8.4.0'
                   annotationProcessor 'com.jakewharton:butterknife-compiler:8.4.0'

BaseRecylerViewAdapterHelper:    compile 'com.github.CymChad:BaseRecyclerViewAdapterHelper:v2.0.0'


FlycoTabLayout:     compile 'com.flyco.tablayout:FlycoTabLayout_Lib:2.1.2@aar'

圆形图片circleImageView     :compile 'de.hdodenhof:circleimageview:2.1.0'

Json解析: Gson

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
