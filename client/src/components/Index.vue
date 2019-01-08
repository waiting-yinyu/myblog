<template>
  <div>
    <div class="center" style="width: 752px;">
        <el-input v-model="searchContent" placeholder="请输入内容"></el-input><el-button @click="search(searchContent)">默认按钮</el-button>
        <el-table :data = 'userData' height="1080" stripe border style="width: 100%">
            <el-table-column prop="id" label="ID" width="80"></el-table-column>
            <el-table-column prop="userName" label="名字" width="120"></el-table-column>
            <el-table-column prop="userAge" label="年龄" width="80"></el-table-column>
            <el-table-column prop="userAddress" label="地址" width="300"></el-table-column>
            <el-table-column label="操作" width="160">
                <template slot-scope="scope">
                    <el-button @click="handleClick(scope.row)" type="text" size="small">查看</el-button>
                    <router-link :to="{ path: 'add' }"><el-button type="text" size="small">新建</el-button></router-link>
                    <router-link :to="{ path: 'edit', query: {id: scope.row.id} }"><el-button type="text" size="small">编辑</el-button></router-link>
                    <el-button @click="deleted(scope.row.id)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>
    </div>
  </div>
</template>

<script>
import axios from 'axios'
export default {
    data() {
        return {
            userData: '',
            searchContent: ''
        }
    },
    methods: {
        handleClick(row) {
            this.$log.debug(row)
        },
        addUser() {
            axios({
                method:'post',
                url: 'http://localhost:8001/addUser',
                data: "&userName=" + "关羽" + "&userAge=" + "98" + "&userAddress=" + "东汉荆州"
            })
            .then(response => {
                this.$log.debug(response)
                window.location.replace('/add')
            }).catch(error => {
                this.$log.debug(error)
            })
        },
        getData() {
            axios
                .get('http://localhost:8001/selectAll')
                .then(response => {
                    this.userData = response.data
                    this.$log.debug(response)
                }).catch(error => {
                    this.$log.debug(error)  
                })
        },
        deleted(id) {
            var deleteConfirm = confirm('是否刪除')
            if(deleteConfirm){
                axios({
                    method: 'post',
                    url: 'http://localhost:8001/deleteUser',
                    data: "&id=" + id
                }).then(response => {
                    this.$log.debug(response)
                    this.getData();
                }).catch(error => {
                    this.$log.debug(error)  
                })
            }
        },
        search(searchName) {
             this.$log.debug("searchContent:",searchName)
            if(searchName != ''){
            axios.get('http://localhost:8001/selectByName',{
                    params:{
                        userName: searchName
                    }
                }).then(response => {
                    this.$log.debug(response)
                    this.userData = response.data
                }).catch(error => {
                    this.$log.debug(error)
                })
            }else{
                this.getData()
            }
        }
    },
    created() {
        this.getData()
    }
}
</script>

<style scoped>
    .center {
        margin-left: auto;
        margin-right: auto;
    }
</style>
