// new Vue({
// 	el : '#loginWindow',
// 	data : {
// 		name : '',
// 		password : ''
// 	},
// 	methods : {
// 		check : function(event) {
// 			// 获取值
// 			var name = this.name;
// 			var password = this.password;
// 			if (name == '' || password == '') {
// 				this.$message({
// 					message : '账号或密码为空！',
// 					type : 'error'
// 				})
// 				return;
// 			}
// 			$.ajax({
// 				url : 'login',
// 				type : 'post',
// 				data : {
// 					name : name,
// 					password : password
// 				},
// 				success : function(data) {
// 					var result = data.result;
// 					if (result == 'true' || result == true) {
// 						alert("登录成功");
// 					} else {
// 						alert("登录失败");
// 					}
// 				},
// 				error : function(data) {
// 					alert(data);
// 				},
// 				dataType : 'json',
// 			})
// 		}
// 	}
// })

new Vue({
	el: '#loginWindow',
	data: {
		user: {
			name: '',
			password: '',
//			verify: '',
		}
	},
})