
var overview = {
    template: '#overview',
    //    created(){//生命周期钩子函数
    //    	console.log(this.$route.path);
    //    }
}
var problem = {
    template: '#problem',
}
var statistics = {
    template: '#statistics',
}
var about = {
    template: '#about',
}

var router = new VueRouter({
    routes: [
        // path 表示监听路由地址
        // component组件模板-> 如果path是正确的路由地址，那就就展示路径所对应的组件模板样式
        // 这里使用了重定向redirect
        {
        path: '/',
        redirect: '/overview',
        },
        {
            path: '/overview',
            component: overview,
        },
        {
            path: '/problem',
            component: problem
        }, {
            path: '/statistics',
            component: statistics
        },
        {
            path: '/about',
            component: about
        },
    ]
})

//dashboard-vue实例
var dashboard= new Vue({
    el: "#dashboard",
    router,
    methods: {
        handleSizeChange(val) {
            console.log(`每页 ${val} 条`);
        },
        handleCurrentChange(val) {
            console.log(`当前页: ${val}`);
        }
    },
    data() {
        const item = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
    }
})