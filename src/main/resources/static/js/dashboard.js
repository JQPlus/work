var router = new VueRouter({
    routes: [
        // path 表示监听路由地址
        // component组件模板-> 如果path是正确的路由地址，那就就展示路径所对应的组件模板样式
    	//这里通过router和<router-view>组件来实现，其实后面定义的component组件中的template都是被<router-view>封装
        // 这里使用了重定向redirect
        {
            path: '/',
            redirect: '/overview',
        },
        {
            path: '/overview',
            component: {
                template: '#overview-template',
                // created() {//生命周期钩子函数
                //     console.log(this.$route.path);
                // }
            }
        },
        {
            path: '/problem',
            component: {
            	//props定义一个组件属性
                props: ['mydata'],
                template: '#problem-template'
            }
        }, {
            path: '/statistics',
            component: {
                template: '#statistics-template'
            }
        },
        {
            path: '/about',
            component: {
                template: '#about-template'
            }
        },
    ]
})

//dashboard-vue实例
var dashboard = new Vue({
    el: "#dashboard-template",
    router,
    methods: {
    },
    data() {
        const tableItem = {
            date: '2016-05-02',
            name: '王小虎',
            address: '上海市普陀区金沙江路 1518 弄'
        };
        return {
            // search: '',
            tableData: Array(20).fill(tableItem),
        }
    }
})

// var problems = new Vue({
//     //	el:"#problem-template",
//     methods: {},
//     data() {
//         const item = {
//             date: '2016-05-02',
//             name: '王小虎',
//             address: '上海市普陀区金沙江路 1518 弄'
//         };
//         return {
//             // search: '',
//             tableData: Array(20).fill(item),
//             currentPage1: 5,
//             currentPage2: 5,
//             currentPage3: 5,
//             currentPage4: 4
//         }
//     }
// })