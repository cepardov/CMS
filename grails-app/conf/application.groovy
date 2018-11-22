grails.plugin.springsecurity.auth.loginFormUrl = '/login'
grails.plugin.springsecurity.logout.filterProcessesUrl="/logoff"
grails.plugin.springsecurity.logout.afterLogoutUrl="/"

// Added by the Spring Security Core plugin:
grails.plugin.springsecurity.userLookup.userDomainClassName = 'cms.User'
grails.plugin.springsecurity.userLookup.authorityJoinClassName = 'cms.UserRole'
grails.plugin.springsecurity.authority.className = 'cms.Role'
grails.plugin.springsecurity.controllerAnnotations.staticRules = [
    [pattern: '/dbconsole/**',	 access: ['ROLE_ADMIN']],
	[pattern: '/',               access: ['permitAll']],
	[pattern: '/error',          access: ['permitAll']],
	[pattern: '/index',          access: ['permitAll']],
	[pattern: '/index.gsp',      access: ['permitAll']],
	[pattern: '/shutdown',       access: ['permitAll']],
	[pattern: '/assets/**',      access: ['permitAll']],
	[pattern: '/**/js/**',       access: ['permitAll']],
	[pattern: '/**/css/**',      access: ['permitAll']],
	[pattern: '/**/images/**',   access: ['permitAll']],
	[pattern: '/**/favicon.ico', access: ['permitAll']]
]

grails.plugin.springsecurity.filterChain.chainMap = [
	[pattern: '/assets/**',      filters: 'none'],
	[pattern: '/**/js/**',       filters: 'none'],
	[pattern: '/**/css/**',      filters: 'none'],
	[pattern: '/**/images/**',   filters: 'none'],
	[pattern: '/**/favicon.ico', filters: 'none'],
	[pattern: '/**',             filters: 'JOINED_FILTERS']
]

