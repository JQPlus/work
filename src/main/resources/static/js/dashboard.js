
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

new Vue({
    el: "#app",
    methods: {},
    data: {},
    router: router,

})