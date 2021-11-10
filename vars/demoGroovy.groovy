def call(body){
  def config = [:]
  body.resolveStrategy = Closure.DELEGATE_FIRST
  body.delegate = config
  body()
  def p_mailList  = config.mailList ?: 'def@xyz.com';
  
  properties([
    parameters([
      stringParam(name: 'mail', defaultValue: config.mailList, description: 'param description')
      ])
    ])
    
  echo params.mail
}
