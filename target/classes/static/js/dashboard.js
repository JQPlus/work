// var overview={
// 		 template: '#overview-template',
//          // created() {//生命周期钩子函数
//          //     console.log(this.$route.path);
//          // }
// }
// var problem={
//         //props定义一个组件属性
//         props: ['mydata'],
//         template: '#problem-template'
// }
// var statistics={
//     template: '#statistics-template'
// }
// var about={
//     template: '#about-template',
// }

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
            // component:overview,
        },
        {
            path: '/problem',
            component: {
                //props定义一个组件属性
                props: ['mydata'],
                template: '#problem-template'
            }
            // component:problem,
        }, {
            path: '/statistics',
            component: {
                template: '#statistics-template'
            }
            // component:statistics
        },
        {
            path: '/about',
            component: {
                template: '#about-template'
            }
            // component:about
        },
    ]
})

const tableItem = {
    date: '2016-05-02',
    name: '王小虎',
    address: '上海市普陀区金沙江路 1518 弄',
    status: '新建',
    priority: '致命',
    belongto: '1' + 'to' + '2',
};

//dashboard-vue实例
var dashboard = new Vue({
    el: "#dashboard-template",
    router,
    methods: {
        statusDropdownChoose,
        priorityDropdownChoose,
    },
    data() {

        return {
            // search: '',
            tableData: Array(20).fill(tableItem),
        }
    }
})
//状态数组
var statusDropdown = [
    { text: '新建' ,color:'rgba(31,93,234,1)'},
    { text: '处理中',color:'rgba(255,149,0,1)' },
    { text: '已拒绝' ,color:'rgba(107,121,142,1)'},
    { text: '已验收' ,color:'rgba(37,179,250,1)'},
    { text: '已解决',color:'rgba(0,193,133,1)' }
]
//将command（状态）值赋给表中数据
function statusDropdownChoose(command) {
    tableItem.status = command;
}

//优先级数组
var priorityDropdown = [
    { text: '致命' },
    { text: '严重' },
    { text: '一般' },
    { text: '轻微' },
]
//将command（优先级）值赋给表中数据
function priorityDropdownChoose(command) {
    tableItem.priority = command;
}
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