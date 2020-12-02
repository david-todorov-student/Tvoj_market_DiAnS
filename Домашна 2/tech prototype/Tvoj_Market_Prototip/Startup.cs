using Microsoft.Owin;
using Owin;

[assembly: OwinStartupAttribute(typeof(Tvoj_Market_Prototip.Startup))]
namespace Tvoj_Market_Prototip
{
    public partial class Startup
    {
        public void Configuration(IAppBuilder app)
        {
            ConfigureAuth(app);
        }
    }
}
