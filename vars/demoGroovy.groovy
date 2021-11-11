def call(body){
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  def p_mailList  = config.mailList ?: 'def@xyz.com';
  def p_node = config.node;
  
  properties([
    parameters([
      stringParam(name: 'mail', defaultValue: "${p_mailList}", description: 'param description')
      ])
    ])
     
  node("${p_node}"){
    stage('code checkout'){
      git 'https://github.com/praveensomayaji/DevOpsClassCodes.git'
  }
    stage('Compile'){
      bat 'mvn compile'
    }
    
    stage('Package'){
      bat 'mvn package'
    }
  echo params.mail
}
}
