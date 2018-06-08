var vm = new Vue({
    el:'#app',
    data:{
        showList : true,
        title : null,
        sysDept : {
            userName : null
        }
    },
    methods: {
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.sysDept = {userName : null};
            vm.getMenu();
        },
        saveOrUpdate: function (event) {
        	var self = this;
        	console.log(1);
        	self.$validate(true, function () {            
                if (self.$validation.invalid) {
        		console.log(2);
            	var url = vm.sysResource.id == null ? "/sysResource/save" : "/sysResource/update";
            	$.ajax({
            		type: "POST",
            		url: ctx + url,
            		contentType: "application/json",
            		data: JSON.stringify(vm.sysResource),
            		dataType : "json",
            		success : function(r){
            			if(r.code === 200){
            				alert('操作成功');
            				vm.reload();
            			}else{
            				alert(r.message);
            			}
            		}
            	});
        	}
        	})
        },
        reload:function(){
        	
        }
    }
});