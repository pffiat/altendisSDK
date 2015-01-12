

AUI().ready(

	/*
	This function gets loaded when all the HTML, not including the portlets, is
	loaded.
	*/

	function() {
		AUI().use(
				'gallery-affix',
				'anim',
				'aui-node',
				'aui-modal',
				function(Y) {
				
				if(Y.one(".flow-navbar") !== null) {
					var navbarButton = Y.one(".flow-navbar").one(".btn-toggle");
			        var navbarCollapse = Y.one(".flow-navbar").one(".nav-collapse");
	
			        navbarButton.on('click', function (e) {
			            if (navbarCollapse.hasClass("in")) {
			                navbarCollapse.removeClass("in");
			                navbarCollapse.setStyle("height", "0px");
			            } else {
			                navbarCollapse.addClass("in");
			                navbarCollapse.setStyle("height", "auto");
			            }
			        });
						
					// navbar fixed to top when scrolling
					Y.all('#myNavbar').plug(Y.Plugin.Affix, {
				        offset: {
				            top: 1
				        }
				    });
				}
				
				//smooth scroll to link
				Y.all('.animate-scroll').on(
					'click',
					function(event) {
						event.preventDefault();
						 if (navbarCollapse !== null && navbarCollapse.hasClass("in")) {
			                navbarCollapse.removeClass("in");
			                navbarCollapse.setStyle("height", "0px");
			            }

						var section = Y.one(event.currentTarget.get('hash'));
						var scrollTo = section.getY()-80;

						new Y.Anim(
						{
							duration: 0.5,
							easing: 'easeBoth',
							node: 'win',
							to: {
								scroll: [0, scrollTo]
							}
						}
						).run();
				});
				
				//popup Mentions légales
				var mentions = new Y.Modal({
			        modal: true,
			        visible:false,
					centered: true,
					zIndex: 1100,
			        headerContent: '<h3>Mentions légales</h3>',
			        bodyContent: Y.one("#mentionsLegales")
				}).render();
				
				Y.one("#aboutModal").on(
					'click', 
					function(event) {
						event.preventDefault();
						mentions.show();
				});
			});
	}
);

Liferay.Portlet.ready(

	/*
	This function gets loaded after each and every portlet on the page.

	portletId: the current portlet's id
	node: the Alloy Node object of the current portlet
	*/

	function(portletId, node) {
	}
);

Liferay.on(
	'allPortletsReady',

	/*
	This function gets loaded when everything, including the portlets, is on
	the page.
	*/

	function() {
	}
);