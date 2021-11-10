def call(body){
  def config = [:]
  body.delegate = config
  body()
  def p_mailList  = config.mailList;
  
  properties([
    parameters([
      stringParam(name: 'mail', defaultValue: p_mailList, description: 'param description')
      ])
    ])
    
  echo param.mail
}
