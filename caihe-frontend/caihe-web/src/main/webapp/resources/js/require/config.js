require.config({
    baseUrl: '/resources/js/',
    paths: {
        base: 'page',
        $: 'zepto/zepto.min',
        doT: 'doT/doT.min'
    },
    map: {
        '*': {
            'css': ''
        }
    },
    shim: {
        $: {
            exports: '$'
        },
        'plugins/switch/bootstrap-switch.min': {
            deps: ['$']
        },
        'plugins/starScore': {
            deps: ['$']
        }
    },
    urlArgs: 'v=18'
});