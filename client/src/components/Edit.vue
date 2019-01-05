<template>
    <div>
        <el-form :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="名字" prop="userName">
                <el-input v-model="ruleForm.userName"></el-input>
            </el-form-item>
            <el-form-item label="年龄" prop="userAge">
                <el-input v-model="ruleForm.userAge"></el-input>
            </el-form-item>
            <el-form-item label="地址" prop="userAddress">
                <el-input v-model="ruleForm.userAddress"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="editData('ruleForm')">立即编辑</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script>
import axios from "axios";
export default {
    data() {
      return {
        ruleForm: {
          userName: '',
          userAge: '',
          userAddress: '',
        },
        rules: {
          userName: [
            { required: true, message: '请输入名字', trigger: 'blur' }
          ],
          userAge: [
            { required: true, message: '请输入年龄', trigger: 'blur' }
          ],
          userAddress: [
            { required: true, message: '请输入地址', trigger: 'blur' }
          ]
        }
      };
    },
    methods: {
        getData() {
            axios
                .get("http://localhost:8001/selectId", {
                    params: {
                        id: this.$route.query.id
                    }
                })
                .then(response => {
                    this.ruleForm.userName = response.data.userName;
                    this.ruleForm.userAge = response.data.userAge;
                    this.ruleForm.userAddress = response.data.userAddress;
                    this.$log.debug(response);
                })
                .catch(error => {
                    this.$log.debug(error);
                });
        },
        editData(formName) {  
        this.$refs[formName].validate((valid) => {
        this.$log.debug(this);
          if (valid) {
            axios({
                method:'post',
                url: 'http://localhost:8001/updateUser',
                data: "&id=" + this.$route.query.id + "&userName=" + this.ruleForm.userName + "&userAge=" + this.ruleForm.userAge + "&userAddress=" + this.ruleForm.userAddress
            }).then(response => {
                this.$log.debug(response)
                this.$router.push({path : "/"})
            }).catch(error => {
                this.$log.debug(error)
            })
          } else {
            this.$log.debug('error submit!!');
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      },
    },
    created() {
        this.getData();
    }
};
</script>
