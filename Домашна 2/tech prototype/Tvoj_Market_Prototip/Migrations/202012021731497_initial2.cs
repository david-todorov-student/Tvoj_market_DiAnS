namespace Tvoj_Market_Prototip.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial2 : DbMigration
    {
        public override void Up()
        {
            AddColumn("dbo.Markets", "Longitude", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Markets", "Latitude", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Markets", "Long");
            DropColumn("dbo.Markets", "Lat");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Markets", "Lat", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            AddColumn("dbo.Markets", "Long", c => c.Decimal(nullable: false, precision: 18, scale: 2));
            DropColumn("dbo.Markets", "Latitude");
            DropColumn("dbo.Markets", "Longitude");
        }
    }
}
